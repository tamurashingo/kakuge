package com.github.tamurashingo.kakuge;

public class Operation {
    public static final Operation PUNCH_WEAK = new Operation(1001, "弱パンチ", OperationType.BUTTON);
    public static final Operation PUNCH_NORM = new Operation(1002, "中パンチ", OperationType.BUTTON);
    public static final Operation PUNCH_STRONG = new Operation(1003, "強パンチ", OperationType.BUTTON);
    public static final Operation KICK_WEAK =  new Operation(1004, "弱キック", OperationType.BUTTON);
    public static final Operation KICK_NORM =  new Operation(1005, "中キック", OperationType.BUTTON);
    public static final Operation KICK_STRONG =  new Operation(1006, "強キック", OperationType.BUTTON);
    
    public static final Operation COIN =    new Operation(1010, "コイン", OperationType.BUTTON);
    public static final Operation START =   new Operation(1020, "スタート", OperationType.BUTTON);
    

    public static final Operation NONE =       new Operation(2000, "中立", OperationType.LEVER);
    public static final Operation UP =         new Operation(2001, "上", OperationType.LEVER);
    public static final Operation DOWN =       new Operation(2002, "下", OperationType.LEVER);
    public static final Operation LEFT =       new Operation(2003, "左", OperationType.LEVER);
    public static final Operation RIGHT =      new Operation(2004, "右", OperationType.LEVER);
    public static final Operation UP_LEFT =    new Operation(2005, "左上", OperationType.LEVER);
    public static final Operation UP_RIGHT =   new Operation(2006, "右上", OperationType.LEVER);
    public static final Operation DOWN_LEFT =  new Operation(2007, "左下", OperationType.LEVER);
    public static final Operation DOWN_RIGHT = new Operation(2008, "右下", OperationType.LEVER);
    
    
    public static enum OperationType {
        BUTTON,
        LEVER,
    }
    
    private int id;
    private String name;
    private OperationType operationType;
    
    private Operation(int id, String name, OperationType operationType) {
        this.id = id;
        this.name = name;
        this.operationType = operationType;
    }
    
    public OperationType getOpetionType() {
        return this.operationType;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Operation) {
            Operation operation = (Operation)obj;
            return operation.id == this.id && operation.operationType == this.operationType;
        }
        
        return false;
    }
}
