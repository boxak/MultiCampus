source("crawler.R",encoding = "UTF-8")

url <- "http://media.daum.net/ranking/popular"
title <- page.getContent(url,css = "ul.list_news2 a.link_txt")
press <- page.getContent(url,css = "span.info_news")
news50 <- data.frame(
  newstitle = title,
  newspapername = press
)
write.table(news50,file = "daumnews.csv",sep=",",row.names = FALSE,col.names = TRUE,
            fileEncoding = "CP949")