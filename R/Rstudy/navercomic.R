getwd()
setwd("function")
source("crawler.R",encoding = "UTF-8")

url <- "https://comic.naver.com/genre/bestChallenge.nhn"
comicName <- page.getContent(url, css = "div.challengeInfo > h6.challengeTitle > a")
comicSummary <- page.getContent(url, css = "div.challengeInfo > div.summary")
comicGrade <- page.getContent(url, css = "div.rating_type > strong")
navercomic <- data.frame(
  comicName = comicName,
  comicSummary = comicSummary,
  comicGrade = comicGrade
)
write.table(navercomic,file = "navercomic.csv",sep=",",
            row.names = FALSE,col.names = TRUE,fileEncoding = "CP949")