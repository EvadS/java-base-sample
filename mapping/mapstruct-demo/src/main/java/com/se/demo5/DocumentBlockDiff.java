package com.se.demo5;


public class DocumentBlockDiff {

    private String leftDiff;
    private String rightDiff;
    /**
     * id предыдущей версии
     */
    private String prevId;
    /**
     * id текущей версии
     */
    private String currId;

    private String leftAttribute;
    private String rightAttribute;


    public DocumentBlockDiff() {

    }


    public DocumentBlockDiff(
            String prevId,
            String currId,
            String leftText,
            String rightText,
            String leftAttr,
            String rightAttribute) {
        this.prevId = prevId;
        this.currId = currId;
        this.leftDiff = leftText;
        this.rightDiff = rightText;
        this.leftAttribute = leftAttr;
        this.rightAttribute = rightAttribute;
    }

    public String getLeftDiff() {
        return leftDiff;
    }

    public void setLeftDiff(String leftDiff) {
        this.leftDiff = leftDiff;
    }

    public String getRightDiff() {
        return rightDiff;
    }

    public void setRightDiff(String rightDiff) {
        this.rightDiff = rightDiff;
    }

    public String getPrevId() {
        return prevId;
    }

    public void setPrevId(String prevId) {
        this.prevId = prevId;
    }

    public String getCurrId() {
        return currId;
    }

    public void setCurrId(String currId) {
        this.currId = currId;
    }

    public String getLeftAttribute() {
        return leftAttribute;
    }

    public void setLeftAttribute(String leftAttribute) {
        this.leftAttribute = leftAttribute;
    }

    public String getRightAttribute() {
        return rightAttribute;
    }

    public void setRightAttribute(String rightAttribute) {
        this.rightAttribute = rightAttribute;
    }
}
