library('dplyr')
library('xlsx')
library('writexl')
library('stringr')
Refinary <- function(n){
    str <- ""
    if(n<10){
        str <- paste0("DATA_0",as.character(n),".xls")
    }
    else{
        str <- paste0("DATA_",as.character(n),".xls")
    }
    data <- read.xlsx2(str,sheetIndex=1,startRow=1,header=TRUE)
    data2[,"어휘"] <- NULL
    data2[,"구성.단위"] <- NULL
    data2[,"고유어.여부"] <- NULL
    data2[,"로마자"] <- NULL
    data2[,"로마자.글자"] <- NULL
    data2[,"로마자.소리"] <- NULL
    data2[,"원어"] <- NULL
    data2[,"어원"] <- NULL
    data2[,"발음"] <- NULL
    data2[,"활용"] <- NULL
    data2[,"검색용.이형태"] <- NULL
    data2[,"방언.지역"] <- NULL
    data2[,"문형"] <- NULL
    data2[,"문법"] <- NULL
    data2[,"분류"] <- NULL
    data2[,"용례"] <- NULL
    data2[,"전문.분야"] <- NULL
    data2[,"속담"] <- NULL
    data2[,"관용구"] <- NULL
    data2[,"대역어"] <- NULL
    data2[,"생물.분류군.정보"] <- NULL
    data2[,"역사.정보"] <- NULL
    data2[,"규범.정보"] <- NULL
    data2[,"다중.매체.멀티미디어..정보"] <- NULL
    data2[,"sense_no"] <- NULL
    data2[,"word_no"] <- NULL
    data2[,"다의어.번호"] <- NULL
    data2[,"다의어.순번"] <- NULL
    뜻풀이.음절 <- vector()
    뜻풀이.어절 <- vector()
    size <- nrow(data)
    for(i in 1:size){
        뜻풀이.음절 <- c(뜻풀이.음절,str_length(data[i,3])-str_count(data[i,3],' ')-str_count(data[i,3],',')-str_count(data[i,3],'\\(')-str_count(data[i,3],'\\)')-str_count(data[i,3],fixed("."))-str_count(data[i,3],'‘')-str_count(data[i,3],'’'))
        뜻풀이.어절 <- c(뜻풀이.어절,str_count(data2[i,3],' ')+1)
    }
    writexl::write_xlsx(cbind(data2,뜻풀이.음절,뜻풀이.어절), path = "RefinedData002.xlsx")
}
