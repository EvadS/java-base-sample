package com.se.demo5.mappers;

import com.se.demo5.DocumentStructureDiff;
import com.se.demo5.DocumentStructureDiffResponse;
import com.se.demo5.mappers.DocumentBlockDiffMapper;
import org.mapstruct.Mapper;

import java.util.concurrent.atomic.AtomicLong;


@Mapper(uses = {DocumentBlockDiffMapper.class})
public interface DocumentStructureDiffMapper {
    DocumentStructureDiffResponse toResponse(DocumentStructureDiff documentStructureDiff,AtomicLong blockNumber);

}
