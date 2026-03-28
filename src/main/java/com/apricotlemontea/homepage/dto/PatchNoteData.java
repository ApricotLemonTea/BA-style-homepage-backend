package com.apricotlemontea.homepage.dto;

import lombok.Data;

import java.util.List;

@Data
public class PatchNoteData {
    List<PatchNoteRecord> PatchNoteJa;
    List<PatchNoteRecord> PatchNoteZh;
    List<PatchNoteRecord> PatchNoteEn;
}
