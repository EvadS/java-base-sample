package com.se.demo5;

import java.util.ArrayList;
import java.util.List;

public class DocumentStructureDiffResponse {
    private List<DocumentBlockDiffResponse> item = new ArrayList<>();

    /**
     * Измения дочерних уровней
     */
    private List<DocumentStructureDiffResponse> child = new ArrayList<>();

    /**
     * Добавить результат сравнения в текущий уровень
     * @param documentBlockDiff
     */
    public void addDiffBlocks(DocumentBlockDiffResponse documentBlockDiff) {
        this.item.add(documentBlockDiff);
    }

    public void addDocumentDiffItem(DocumentStructureDiffResponse documentStructureDiff) {
        this.child.add(documentStructureDiff);
    }

    public List<DocumentBlockDiffResponse> getItem() {
        return item;
    }

    public List<DocumentStructureDiffResponse> getChild() {
        return child;
    }
}
