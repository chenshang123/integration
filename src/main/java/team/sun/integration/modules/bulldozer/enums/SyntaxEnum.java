package team.sun.integration.modules.bulldozer.enums;

import team.sun.integration.config.base.enums.ret.BaseKeyValue;

/**
 * 查询语法枚举
 */
public enum SyntaxEnum implements BaseKeyValue<String, String> {
    eq("equal", "精确匹配输入结果"),
    /**
     * not equal
     */
    ne("not equal", "精确匹配排除输入结果"),
    /**
     * greater than
     */
    gt("greater than", "结果大于输入"),
    /**
     * Greater than or equal to
     */
    goe("goe", "结果大于等于输入"),
    /**
     * less than
     */
    lt("lt", "结果小于输入"),
    /**
     * Less than or equal to
     */
    loe("loe", "结果小于等于输入"),
    between("between", "结果两个输入值之间"),
    notBetween("notBetween", "结果不属于两个值之间"),
    in("in", "结果属于集合"),
    notIn("notIn", "结果不属于集合"),
    like("like", "模糊匹配"),
    notLike("notLike", "模糊匹配排除结果"),
    likeIgnoreCase("likeIgnoreCase", "模糊匹配忽略大小写"),
    startsWith("startsWith", "以开始值模糊匹配"),
    startsWithIgnoreCase("startsWithIgnoreCase", "以开始值模糊匹配-忽略大小写"),
    endsWith("endsWith", "以结尾值模糊匹配"),
    endsWithIgnoreCase("endsWithIgnoreCase", "以结尾值模糊匹配-忽略大小写"),
    as("as", "字段别名"),
    isNull("isNull", "结果为空"),
    isNotNull("isNotNull", "结果不能为空"),
    trim("trim", "结果去掉前后空格");


    final String key;
    final String value;

    SyntaxEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public enum StringSyntaxEnum implements BaseKeyValue<String, String> {
        eq("equal", "精确匹配输入结果"),
        /**
         * not equal
         */
        ne("not equal", "精确匹配排除输入结果"),
        /**
         * greater than
         */
        gt("greater than", "结果大于输入"),
        /**
         * Greater than or equal to
         */
        goe("goe", "结果大于等于输入"),
        /**
         * less than
         */
        lt("lt", "结果小于输入"),
        /**
         * Less than or equal to
         */
        loe("loe", "结果小于等于输入"),
        between("between", "结果两个输入值之间"),
        notBetween("notBetween", "结果不属于两个值之间"),
        in("in", "结果属于集合"),
        notIn("notIn", "结果不属于集合"),
        like("like", "模糊匹配"),
        notLike("notLike", "模糊匹配排除结果"),
        likeIgnoreCase("likeIgnoreCase", "模糊匹配忽略大小写"),
        startsWith("startsWith", "以开始值模糊匹配"),
        startsWithIgnoreCase("startsWithIgnoreCase", "以开始值模糊匹配-忽略大小写"),
        endsWith("endsWith", "以结尾值模糊匹配"),
        endsWithIgnoreCase("endsWithIgnoreCase", "以结尾值模糊匹配-忽略大小写"),
        as("as", "字段别名"),
        isNull("isNull", "结果为null"),
        isNotNull("isNotNull", "结果不能为null"),
        isEmpty("isEmpty", "结果为空"),
        isNotEmpty("isNotEmpty", "结果不能为空"),
        trim("trim", "结果去掉前后空格"),
        toLowerCase("toLowerCase", "结果转小写"),
        toUpperCase("toUpperCase", "结果转大写");

        final String key;
        final String value;

        StringSyntaxEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public enum MathSyntaxEnum implements BaseKeyValue<String, String> {
        add("add", "结果加上输入"),
        subtract("subtract", "结果减去输入"),
        multiply("multiply", "结果乘以输入"),
        divide("divide", "结果除以输入"),
        sqrt("sqrt", "结果开平方根"),
        mod("mod", "结果求余数"),
        abs("abs", "结果取绝对值");

        final String key;
        final String value;

        MathSyntaxEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public enum DateSyntaxEnum implements BaseKeyValue<String, String> {

        after("after", "结果时间在输入时间之后"),
        before("before", "结果时间在输入时间之前");

        final String key;
        final String value;

        DateSyntaxEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public enum QuantSyntaxEnum implements BaseKeyValue<String, String> {
        avg_max_col("max", "结果取最大值"),
        avg_min_col("min", "结果取最小值"),
        avg_avg_col("avg", "结果取平均值");

        final String key;
        final String value;

        QuantSyntaxEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public enum AggSyntaxEnum implements BaseKeyValue<String, String> {
        agg_sum("agg_sum", "结果为求和值"),
        agg_max("agg_max", "结果取最大值"),
        agg_min("agg_min", "结果取最小值"),
        agg_avg("agg_avg", "结果取平均值");

        final String key;
        final String value;

        AggSyntaxEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public enum OrderSyntaxEnum implements BaseKeyValue<String, String> {
        asc("asc", "升序"),
        desc("desc", "降序"),
        asc_nullsLast("asc_nullsLast", "升序-空值排在最后"),
        asc_nullsFirst("asc_nullsFirst", "升序-空值排在最前"),
        desc_nullsLast("desc_nullsLast", "降序-空值排在最后"),
        desc_nullsFirst("desc_nullsFirst", "降序-空值排在最前");

        final String key;
        final String value;

        OrderSyntaxEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.key;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }
}
