source("crawler.R",encoding = "UTF-8")

score <- vector()
review <- vector()
for(page in 1:20){
  url <- paste0("https://movie.daum.net/moviedb/grade?movieId=127122&type=netizen&page=",page)
  css.score <- page.getContent(url,css = "em.emph_grade")
  css.review <- page.getContent(url,css = "p.desc_review")
  if(length(css.score)==10 & length(css.review)==10){
    score <- c(score,css.score)
    review <- c(review,css.review)
  }
}
DaumMovieReview2 <- data.frame(
  댓글리뷰=review,
  고객평점=score
)
View(DaumMovieReview2)
?write.csv

write.table(DaumMovieReview2,file="daummovie2.csv",sep=",",row.names = FALSE,
            col.names = TRUE,fileEncoding = "CP949")
# 엑셀로 열면 UTF-8로 했을 때 깨진다. 메모장은 해당없음.