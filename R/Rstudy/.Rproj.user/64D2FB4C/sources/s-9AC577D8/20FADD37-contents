getwd()
setwd("C:/boxak/Rstudy/function")
source("crawler.R",encoding = "UTF-8")

url <- "http://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=default_mysearch&searchword=Java"
selector <- "label.lbl_sfilter > span.txt"
tech_name <- page.getContent(url,css = selector)
selector <- "label.lbl_sfilter > span.count"
info_count <- page.getContent(url,css = selector)

#tech_name 맨 마지막에 불필요한 데이터 제거
tech_name <- tech_name[1:length(tech_name)-1]

#tech_name에서 #제거
tech_name <- gsub("#","",tech_name)

#info_count에서 괄호 제거
info_count <- gsub("[(),]","",info_count)

saramin <- data.frame(
  tech_name = tech_name,
  info_count = info_count
)
write.table(saramin,file = "saramin.csv",col.names = TRUE,row.names = FALSE,
            sep=",",fileEncoding = "CP949")