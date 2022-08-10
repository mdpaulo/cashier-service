package portfolio.projects.cashierService.domain.converters;

import portfolio.projects.cashierService.domain.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {
        if (orderStatus == null){
            return null;
        }
        return orderStatus.getCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer code) {
        if(code == null){
            return null;
        }
        return Stream.of(OrderStatus.values())
                .filter(os -> os.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
