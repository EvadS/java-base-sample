package com.se.demo5;

import java.util.ArrayList;
import java.util.List;

public class DocumentStructureDiff {
    /**
     * Измения в параграфах для дочерних уровней
     */
    private List<DocumentBlockDiff> item = new ArrayList<>();

    /**
     * Измения дочерних уровней
     */
    private List<DocumentStructureDiff> child = new ArrayList<>();

    /**
     * Добавить результат сравнения в текущий уровень
     * @param documentBlockDiff
     */
    public void addDiffBlocks(DocumentBlockDiff documentBlockDiff) {
        this.item.add(documentBlockDiff);
    }

    public void addDocumentDiffItem(DocumentStructureDiff documentStructureDiff) {
        this.child.add(documentStructureDiff);
    }

    public List<DocumentBlockDiff> getItem() {
        return item;
    }

    public List<DocumentStructureDiff> getChild() {
        return child;
    }
}
