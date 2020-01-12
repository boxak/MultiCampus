library('dplyr')
library('xlsx')
library('writexl')
writeInfoPartsOfSpeech <- function(n){
    setwd("C:/Users/82102/Documents/GitHub/MultiCampus/NLP/RefinedDataSet")
    str=""
    if(n<10){
        str=paste0("RefinedData00",as.character(n),".xlsx")
    }
    else{
        str=paste0("RefinedData0",as.character(n),".xlsx")
    }
    data <- read.xlsx2(str,sheetIndex=1,startRow=1,header=TRUE)
    voca <- data %>% count(품사)
    lexicalUnit <- filter(data,의미.번호=="001") %>% count(품사)
    
    if(n<10){
        writexl::write_xlsx(voca, path = paste0("vocaInfo00",as.character(n),".xlsx"))
        writexl::write_xlsx(lexicalUnit, path = paste0("lexicalUnitInfo00",as.character(n),".xlsx"))
    }
    else{
        writexl::write_xlsx(voca, path = paste0("vocaInfo0",as.character(n),".xlsx"))
        writexl::write_xlsx(lexicalUnit, path = paste0("lexicalUnitInfo0",as.character(n),".xlsx"))
    }
    sprintf("%s is created",paste0("vocaInfo0",as.character(n),".xlsx"))
}
