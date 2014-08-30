package com.github.tamurashingo.kakuge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.github.tamurashingo.kakuge.Operation.OperationType;

public class Player implements ITick {

    /** キャラクタ情報 */
    private Character character;
    /** 技マップ */
    private Map<Operation[], Character.Status> special;
    
    /** 状態 */
    private Character.Status status;
    /** 入力バッファ */
    private LinkedList<Operation> operationBuffer;
    
    public Player(Character character, Map<Operation[], Character.Status> special) {
        this.character = character;
        this.special = special;
    }

    public void operation(Operation operation) {
        operationBuffer.push(operation);
    }
    
    @Override
    public void tick(long t) {
        if (checkSpecial() == false) {
            this.status = Character.Status.STAND;
        }
    }
    
    /*-
     * 必殺技のチェック
     */
    /**
     * 必殺技のチェック
     * 
     * @return 必殺技を出したときにtrue
     */
    private boolean checkSpecial() {
        Operation op = operationBuffer.peek();
        // 直前の動作がボタンじゃなければ処理を抜ける
        if (op == null || op.getOpetionType() != OperationType.BUTTON) {
            return false;
        }

        // ボタン入力から以前のキー操作を取得する。
        Operation[] ops = operationBuffer.toArray(new Operation[]{});
        
        // キーバッファを初期化する
        operationBuffer.clear();
        
        for (Map.Entry<Operation[], Character.Status> specialEntry: special.entrySet()) {
            if (Arrays.equals(ops, specialEntry.getKey())) {
                this.status = specialEntry.getValue();
                
                return true;
            }
        }
        
        return false;
    }

    
    /**
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * @param character the character to set
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * @return the status
     */
    public Character.Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Character.Status status) {
        this.status = status;
    }

    /**
     * @return the operationBuffer
     */
    public List<Operation> getOperationBuffer() {
        return operationBuffer;
    }

    /**
     * @param operationBuffer the operationBuffer to set
     */
    public void setOperationBuffer(LinkedList<Operation> operationBuffer) {
        this.operationBuffer = operationBuffer;
    }
}
