path <- "C:/boxak/Rstudy/data/memo.txt"
text <- scan(path,what = "",fileEncoding = "UTF-8",sep = "\n")
text[1] <- gsub("[^가-힣., ]","",text[1])
text[2] <- gsub("e","E",text[2])
text[3] <- gsub("[[:digit:]]","",text[3])
text[4] <- gsub("[A-z][[:blank:]]*","",text[4])
text[5] <- gsub("[^가-힣. ]","",text[5])
text[6] <- gsub(" ","",text[6])
text[7] <- tolower(text[7]) 

#setwd("C:\\boxak\\Rstudy\\data")
write(text,file = "memo_new.txt",sep = "\n")
