package controllers;

import dto.*;
import exceptions.NoParkingLotAvailableException;
import exceptions.NoSpotAvailableException;
import exceptions.NoTicketException;
import exceptions.PaymentFailureException;
import lombok.Getter;
import lombok.Setter;
import models.*;
import services.*;

import java.sql.SQLOutput;
import java.util.Scanner;
@Getter
@Setter
public class DisplayController {
    private ParkingLot parkingLot;
    private InitializeParkingLotService pl = new InitializeParkingLotService();
    private ParkingLotDisplayService pld = new ParkingLotDisplayService();

    public void launch()
    {
        String command = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Commands -: Create parking lot, Display, park vehicle, unpark vehicle");
        while(!command.equals("exit"))
        {   command = sc.nextLine();
            if(command.equals("Create parking lot"))
            {
                this.parkingLot = pl.createParkingLot();
                System.out.println("Parking lot with id "+parkingLot.getParkingLotId()+" has been created");
            }
            else if(command.equals("display"))
            {   if(this.parkingLot==null)
                {
                    System.out.println("No Parking Lots available");
                    throw new NoParkingLotAvailableException();
                }

                System.out.println("Do you want to see ");
                System.out.println("1. Total free slots count in each floor of certain vehicle type");
                System.out.println("2. The id's of free slots in each floor of certain vehicle type");
                System.out.println("3. The occupied slots in each floor of certain vehicle type");
                int num = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter the vehicle type");
                String type = sc.nextLine();

                if(num==1)
                    pld.display_free_cnt(pl.getParkingLot(),type);
                else if(num==2)
                    pld.display_free_slots(getParkingLot(),type);
                else if(num==3)
                    pld.display_occupied_slots(getParkingLot(),type);
                else
                    System.out.println("Enter valid command");

            }
            else if(command.equals("park vehicle")) {
                String vehicle_type, vehicle_colour, vehicle_number;
                System.out.println("Enter the vehicle type, vehicle number and colour");
                vehicle_type = sc.nextLine();
                vehicle_number = sc.nextLine();
                vehicle_colour = sc.nextLine();
                EntryService entryService = new EntryService(this.parkingLot);
                TicketController ticketController = new TicketController(EntryService.builder().parkingLot(this.parkingLot).build());
                try {
                    GenerateTicketResponse response = ticketController.generateTicket(
                            GenerateTicketRequest.builder().vehicle(Vehicle.builder().vehicleType(vehicle_type).vehicleNumber(vehicle_number).colour(vehicle_colour).build()).build());
                    System.out.println("Your TicketId is :" + response.getTicket().getTicketId() + " slot is booked at "
                            + response.getTicket().getParkingSpot().getFloorId() +
                            "th floor and spotId " + response.getTicket().getParkingSpot().getParkingSpotId());
                } catch (NoSpotAvailableException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(command.equals("unpark vehicle"))
            {
                System.out.println("Please enter the ticket ID");
                String ticket_id = sc.nextLine();
                ExitService exitService = new ExitService(this.parkingLot);
                ExitController exitController = new ExitController(ExitService.builder().parkingLot(this.parkingLot).build());
                ExitTicket exitTicket = null;
                try {
                    GenerateExitTicketResponse response = exitController.generateExitTicket(GenerateExitTicketRequest.builder().entryTicketId(ticket_id).build());
                    exitTicket = response.getExitTicket();
                } catch (NoTicketException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Your total charge is : "+exitTicket.getAmount());
                System.out.println("Please pay the mentioned amount");
                System.out.println("----Select Service---");
                System.out.println("1. Debit Card");
                System.out.println("2. Credit Card");
                System.out.println("3. UPI");

                int option = 0;
                option = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter bank name --(AXIS, SBI, ICICI)");
                String bankName = "";
                bankName = sc.nextLine();
                if(option==0 || bankName.equals(""))
                {
                    System.out.println("Invalid option--Try again");
                }
                System.out.println("Initializing Payment Gateway");

                PaymentController paymentController = new PaymentController(PaymentService.builder().parkingLot(this.parkingLot).exitTicket(exitTicket).build());
                try
                {
                    InitiatePaymentResponse response = paymentController.generateTransaction(InitiatePaymentRequest.builder().
                            paymentMode(option).bankName(bankName).build());
                    System.out.println("Payment has been successfully done");
                    System.out.println();
                    System.out.println("---------------INVOICE--------------");
                    System.out.println("TransactionID : "+ response.getInvoice().getTransactionId());
                    System.out.println("Transaction Type : "+ response.getInvoice().getTransactionMode());
                    System.out.println("Amount :" +exitTicket.getAmount());
                    System.out.println("Entry Time :"+response.getInvoice().getEntryTime().getHour()+":"+response.getInvoice().getEntryTime().getMinute());
                    System.out.println("Entry Time :"+response.getInvoice().getExitTime().getHour()+":"+response.getInvoice().getExitTime().getMinute());
                    System.out.println("------------------------------------");
                }
                catch(PaymentFailureException e)
                {
                    throw new RuntimeException(e);
                }

            }
            else
            {
                System.out.println("Please enter proper commands as mentioned");
            }

            }

        }
    }

