package team.sun.integration.config.base.enums.converter;


import javax.persistence.AttributeConverter;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public abstract class BaseEnumConverter<X extends BaseEnum<Y>, Y> implements AttributeConverter<BaseEnum<Y>, Y> {
    private final Method valuesMethod;

    @SuppressWarnings("unchecked")
    public BaseEnumConverter() {
        Class<X> clazz = (Class<X>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments())[0];
        try {
            valuesMethod = clazz.getMethod("values");
        } catch (Exception e) {
            throw new RuntimeException("can't get values method from " + clazz);
        }
    }

    @Override
    public Y convertToDatabaseColumn(BaseEnum<Y> attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public X convertToEntityAttribute(Y dbData) {
        if(dbData == null){
            return null;
        }
        try {
            X[] values = (X[]) valuesMethod.invoke(null);
            for (X x : values) {
                if (x.getValue().equals(dbData)) {
                    return x;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("can't convertToEntityAttribute" + e.getMessage());
        }
        throw new RuntimeException("unknown dbData " + dbData);
    }
}
