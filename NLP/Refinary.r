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
    print("1 ")
    data <- read.xlsx2(str,sheetIndex=1,startRow=1,header=TRUE)
    print("2 ")
    data[,"어휘"] <- NULL
    data[,"구성.단위"] <- NULL
    data[,"고유어.여부"] <- NULL
    data[,"로마자"] <- NULL
    data[,"로마자.글자"] <- NULL
    data[,"로마자.소리"] <- NULL
    data[,"원어"] <- NULL
    data[,"어원"] <- NULL
    data[,"발음"] <- NULL
    data[,"활용"] <- NULL
    data[,"검색용.이형태"] <- NULL
    data[,"방언.지역"] <- NULL
    data[,"문형"] <- NULL
    data[,"문법"] <- NULL
    data[,"분류"] <- NULL
    data[,"용례"] <- NULL
    data[,"전문.분야"] <- NULL
    data[,"속담"] <- NULL
    data[,"관용구"] <- NULL
    data[,"대역어"] <- NULL
    data[,"생물.분류군.정보"] <- NULL
    data[,"역사.정보"] <- NULL
    data[,"규범.정보"] <- NULL
    data[,"다중.매체.멀티미디어..정보"] <- NULL
    data[,"sense_no"] <- NULL
    data[,"word_no"] <- NULL
    data[,"다의어.번호"] <- NULL
    data[,"다의어.순번"] <- NULL
    뜻풀이.음절 <- vector()
    뜻풀이.어절 <- vector()
    size <- nrow(data)
    print("3 ")
    for(i in 1:size){
        뜻풀이.음절 <- c(뜻풀이.음절,str_length(data[i,3])-str_count(data[i,3],' ')-str_count(data[i,3],',')-str_count(data[i,3],'\\(')-str_count(data[i,3],'\\)')-str_count(data[i,3],fixed("."))-str_count(data[i,3],'‘')-str_count(data[i,3],'’'))
        뜻풀이.어절 <- c(뜻풀이.어절,str_count(data[i,3],' ')+1)
    }
    data[,"뜻풀이"] <- NULL
    print("4 ")
    if(n<10){
        writexl::write_xlsx(cbind(data,뜻풀이.음절,뜻풀이.어절), path = paste0("RefinedData00",as.character(n),".xlsx"))
    }
    else{
        writexl::write_xlsx(cbind(data,뜻풀이.음절,뜻풀이.어절), path = paste0("RefinedData0",as.character(n),".xlsx"))
    }
    sprintf("%s is refined successfully",str)
}
