package com.se.demo5.mappers;

import com.se.demo5.DocumentBlockDiff;
import com.se.demo5.DocumentBlockDiffResponse;
import com.se.demo5.DocumentStructureDiff;
import com.se.demo5.DocumentStructureDiffResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Mapper
public interface DocumentBlockDiffMapper {

    @Named("inchToNumber")
    static long incrementNumber(final AtomicLong blockNumber) {
        return blockNumber.incrementAndGet();
    }

    @Mapping(target = "leftDiff", source = "blockDiff.leftDiff")
    @Mapping(target = "rightDiff", source = "blockDiff.rightDiff")
    @Mapping(target = "prevId", source = "blockDiff.prevId")
    @Mapping(target = "currId", source = "blockDiff.currId")
    @Mapping(target = "leftAttribute", source = "blockDiff.leftAttribute")
    @Mapping(target = "rightAttribute", source = "blockDiff.rightAttribute")
    @Mapping(target = "number", source = "blockNumber", qualifiedByName = "inchToNumber")
    DocumentBlockDiffResponse toResponse(DocumentBlockDiff blockDiff, AtomicLong blockNumber);


    DocumentBlockDiffResponse documentBlockDiffToDocumentBlockDiffResponse(DocumentBlockDiff documentBlockDiff, AtomicLong blockNumber);
}

