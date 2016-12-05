def article = new Article(title: 'Groovy Goodness')

assert article.title == 'Groovy Goodness'
assert article.type == BLOG
assert article.class.name == 'com.mrhaki.blog.Post'

println article
