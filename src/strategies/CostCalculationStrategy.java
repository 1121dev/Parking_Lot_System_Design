package strategies;

import java.time.LocalDateTime;
import java.util.Date;

public interface CostCalculationStrategy {
    double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime);
}
