package strategies;

import strategies.CostCalculationStrategy;

import java.time.LocalDateTime;
import java.util.Date;

public class DefaultCostCalcuationStrategy implements CostCalculationStrategy {

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {
        Double timeDifferenceMillis = Math.abs((double) (exitTime.getMinute() - entryTime.getMinute()));

        // Convert milliseconds to minutes
        System.out.println("Your Car was parked for : "+timeDifferenceMillis+" mins");
        Double timeDifferenceMinutes = Math.abs(timeDifferenceMillis);

        //per min cost is Rs 1000/- and GST is Rs 20/-

        return (double) Math.round((timeDifferenceMinutes*1000.0)+20.0);
    }


}
