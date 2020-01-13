library('dplyr')
library('xlsx')
library('writexl')
writeInfoPartsOfSpeech <- function(n){
    setwd("C:/Users/student/MultiCampus/NLP")
    str=""
    if(n<10){
        str=paste0("RefinedData00",as.character(n),".csv")
    }
    else{
        str=paste0("RefinedData0",as.character(n),".csv")
    }
    data <- read.csv(str,header=FALSE,fileEncoding="UTF-8")
    lexicalUnit <- data %>% count(품사)
    voca <- filter(data,의미.번호=="001") %>% count(품사)
    
    if(n<10){
        write.table(voca,file=paste0("vocaData00",as.character(n),".csv"),row.names=TRUE,col.names=FALSE,append=T,sep=",",fileEncoding="UTF-8")
        write.table(lexicalUnit,file=paste0("lexicalUnitData00",as.character(n),".csv"),row.names=TRUE,col.names=FALSE,append=T,sep=",",fileEncoding="UTF-8")
    }
    else{
        write.table(voca,file=paste0("vocaData0",as.character(n),".csv"),row.names=TRUE,col.names=FALSE,append=T,sep=",",fileEncoding="UTF-8")
        write.table(lexicalUnit,file=paste0("lexicalUnitData0",as.character(n),".csv"),row.names=TRUE,col.names=FALSE,append=T,sep=",",fileEncoding="UTF-8")
    }
    sprintf("%s is created",paste0("vocaInfo0",as.character(n),".xlsx"))
}
