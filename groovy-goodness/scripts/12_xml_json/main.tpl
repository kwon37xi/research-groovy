html {
    head {
        // Use pageTitle layout property
        title(pageTitle)
    }
    body {
        section(id: 'main') {
            mainContents()
        }

        section(id: 'actions') {
            actions()
        }

        footer {
            // 템플릿은 groovy code이다.
            // 따라서 변수 혹은 메소드 선언이 가능하다.
            def generatedOn = pubDate ?: new Date()
            p("Generated on ${dateFormat(generatedOn)}")
        }
    }
}

def dateFormat(date) {
    date.format('dd-MM-yyyy')
}
