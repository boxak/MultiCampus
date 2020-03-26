source("crawler.R",encoding = "UTF-8")

url <- "https://movie.daum.net/moviedb/grade?movieId=127122&type=netizen&page=1"
css.score <- page.getContent(url,css = "em.emph_grade")
css.review <- page.getContent(url,css = "p.desc_review")
DaumMovieReview <- data.frame(
  댓글리뷰=css.review,
  고객평점=css.score
)
View(DaumMovieReview)
?write.csv

write.table(DaumMovieReview,file="daummovie.csv",sep=",",row.names = FALSE,
          col.names = TRUE,fileEncoding = "CP949")