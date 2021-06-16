package team.sun.integration.modules.sys.config.enums;


public enum ViewSelectionEnum {
    //查询厂家信息 manufacturer
    VIEW_MANUFACTURER(1, "view_selection_manufacturer"),
    //地市查询 3.4 city
    VIEW_CITY(2, "view_selection_city"),
    //区县 5.6 county
    VIEW_COUNTY(3, "view_selection_county"),
    //班组 team
    VIEW_TEAM(4, "view_selection_team"),
    //查询库房信息 storeroom
    VIEW_STOREROOM(5, "view_selection_storeroom"),
    //工器具分类类型 classify
    VIEW_CLASSIFY_ONE(6, "view_selection_classify"),
    VIEW_CLASSIFY_TWO(7, "view_selection_classify"),
    VIEW_CLASSIFY_THREE(8, "view_selection_classify");

    private final Integer code;
    private String view;

    ViewSelectionEnum(Integer code, String view) {
        this.code = code;
        this.view = view;
    }

//    @JsonCreator
//    public static ShopRunStateEnum getByCode(int code) {
//        for (ShopRunStateEnum value : ShopRunStateEnum.values()) {
//            if (Objects.equals(code, value.getShopRunState())) {
//                return value;
//            }
//        }
//        return null;
//    }

    public Integer getCode() {
        return code;
    }

    public String getView() {
        return view;
    }

}
