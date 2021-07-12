package team.sun.integration.config.base.tool.reflect;

import com.querydsl.core.types.dsl.NumberPath;
import org.hibernate.annotations.GenericGenerator;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
@Entity
public class TestVo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;

    private BigDecimal packageBigDecimal;
    //public final NumberPath<BigDecimal> packageBigDecimal = createNumber("packageBigDecimal", java.math.BigDecimal.class);


    private Boolean packageBoolean;
    //public final BooleanPath packageBoolean = createBoolean("packageBoolean");
    //public final BooleanPath baseBoolean = createBoolean("baseBoolean");
    private boolean baseBoolean;

    private Character packageCharacter;
    //public final ComparablePath<Character> packageCharacter = createComparable("packageCharacter", Character.class);
    //public final ComparablePath<Character> baseChar = createComparable("baseChar", Character.class);
    private char baseChar;

    private Byte packageByte;
    //public final NumberPath<Byte> packageByte = createNumber("packageByte", Byte.class);
    //public final NumberPath<Byte> baseByte = createNumber("baseByte", Byte.class);
    private byte baseByte;

    private Double packageDouble;
    //public final NumberPath<Double> packageDouble = createNumber("packageDouble", Double.class);
    //public final NumberPath<Double> baseDouble = createNumber("baseDouble", Double.class);
    private double baseDouble;

    private Float packageFloat;
    //public final NumberPath<Float> packageFloat = createNumber("packageFloat", Float.class);
    //public final NumberPath<Float> baseFloat = createNumber("baseFloat", Float.class);
    private float baseFloat;

    private Integer packageInteger;
    //public final NumberPath<Integer> packageInteger = createNumber("packageInteger", Integer.class);
    //public final NumberPath<Integer> baseInteger = createNumber("baseInteger", Integer.class);
    private int baseInteger;

    private Long packageLong;
    //public final NumberPath<Long> packageLong = createNumber("packageLong", Long.class);
    //public final NumberPath<Long> baseLong = createNumber("baseLong", Long.class);
    private long baseLong;

    private Short packageShort;
    //public final NumberPath<Short> packageShort = createNumber("packageShort", Short.class);
    //public final NumberPath<Short> baseShort = createNumber("baseShort", Short.class);
    private short baseShort;

    private String string;
    //public final StringPath string = createString("string");

    private Date date;
    //public final DateTimePath<Date> date = createDateTime("date", java.util.Date.class);

    private LocalDateTime localDateTime;
    //public final DateTimePath<java.time.LocalDateTime> localDateTime = createDateTime("localDateTime", java.time.LocalDateTime.class);



    public BigDecimal getPackageBigDecimal() {
        return packageBigDecimal;
    }

    public void setPackageBigDecimal(BigDecimal packageBigDecimal) {
        this.packageBigDecimal = packageBigDecimal;
    }

    public Boolean getPackageBoolean() {
        return packageBoolean;
    }

    public void setPackageBoolean(Boolean packageBoolean) {
        this.packageBoolean = packageBoolean;
    }

    public boolean isBaseBoolean() {
        return baseBoolean;
    }

    public void setBaseBoolean(boolean baseBoolean) {
        this.baseBoolean = baseBoolean;
    }

    public Character getPackageCharacter() {
        return packageCharacter;
    }

    public void setPackageCharacter(Character packageCharacter) {
        this.packageCharacter = packageCharacter;
    }

    public char getBaseChar() {
        return baseChar;
    }

    public void setBaseChar(char baseChar) {
        this.baseChar = baseChar;
    }

    public Byte getPackageByte() {
        return packageByte;
    }

    public void setPackageByte(Byte packageByte) {
        this.packageByte = packageByte;
    }

    public byte getBaseByte() {
        return baseByte;
    }

    public void setBaseByte(byte baseByte) {
        this.baseByte = baseByte;
    }

    public Double getPackageDouble() {
        return packageDouble;
    }

    public void setPackageDouble(Double packageDouble) {
        this.packageDouble = packageDouble;
    }

    public double getBaseDouble() {
        return baseDouble;
    }

    public void setBaseDouble(double baseDouble) {
        this.baseDouble = baseDouble;
    }

    public Float getPackageFloat() {
        return packageFloat;
    }

    public void setPackageFloat(Float packageFloat) {
        this.packageFloat = packageFloat;
    }

    public float getBaseFloat() {
        return baseFloat;
    }

    public void setBaseFloat(float baseFloat) {
        this.baseFloat = baseFloat;
    }

    public Integer getPackageInteger() {
        return packageInteger;
    }

    public void setPackageInteger(Integer packageInteger) {
        this.packageInteger = packageInteger;
    }

    public int getBaseInteger() {
        return baseInteger;
    }

    public void setBaseInteger(int baseInteger) {
        this.baseInteger = baseInteger;
    }

    public Long getPackageLong() {
        return packageLong;
    }

    public void setPackageLong(Long packageLong) {
        this.packageLong = packageLong;
    }

    public long getBaseLong() {
        return baseLong;
    }

    public void setBaseLong(long baseLong) {
        this.baseLong = baseLong;
    }

    public Short getPackageShort() {
        return packageShort;
    }

    public void setPackageShort(Short packageShort) {
        this.packageShort = packageShort;
    }

    public short getBaseShort() {
        return baseShort;
    }

    public void setBaseShort(short baseShort) {
        this.baseShort = baseShort;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

}
