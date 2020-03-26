library(rvest)
library(stringr)
install.packages('dplyr')
library(dplyr)
getwd()
setwd('function')
source("crawler.R",encoding = "UTF-8")
encoding = "CP949"
datelist <- vector()
pricelist <- vector()
url <- paste0("https://finance.naver.com/sise/sise_index_day.nhn?code=KPI200&page=",1)
endpage <- page.getAttr(url = url,css="td.pgRR > a",encoding = encoding)
endpage <- str_match(endpage,pattern = "page=\\d*")
endpage <- str_remove_all(endpage,"[^0-9]")
endpage <- as.integer(endpage)
for(page in 1:endpage){
  url <- paste0("https://finance.naver.com/sise/sise_index_day.nhn?code=KPI200&page=",page)
  tempdate <- page.getContent(url = url,css = "td.date",encoding = "CP949",trim = TRUE)
  tempprice <- page.getContent(url = url,css = "table.type_1 td:nth-child(2)",encoding = encoding,trim = TRUE)
  tempdate <- tempdate[tempdate!=""]
  tempprice <- tempprice[tempprice!=""]
  datelist <- c(datelist,tempdate)
  pricelist <- c(pricelist,tempprice)
}
lastday <- as.Date(datelist[1],format="%Y.%m.%d")
firstday <- as.Date(datelist[length(datelist)],format="%Y.%m.%d")
interval <- seq(firstday,by="day",length.out = as.integer(lastday-firstday))

stockInfo <- cbind(datelist,pricelist)
stockInfo[,1] <- as.Date(stockInfo[,1],format="%Y.%m.%d")
head(stockInfo)
colnames(interval)
interval <- data.frame(datelist = interval)

left_join(interval,stockInfo, by=)
