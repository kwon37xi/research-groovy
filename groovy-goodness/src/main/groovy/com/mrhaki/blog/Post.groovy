package com.mrhaki.blog

import groovy.transform.ToString

@ToString
class Post {
    String title
    Type type = Type.BLOG
}


enum Type {
    BLOG, NEWS
}