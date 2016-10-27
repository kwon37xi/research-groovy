// 메소드의 마지막인자로 closure를 넘길 때는 인자 목록 밖에 {}로 둘 수 있다.
def work(input, cl) {
    cl(input)
}


def assertJava = {
    assert it == 'Java'
}

work('Java', assertJava)

work 'Java', assertJava

work('Groovy', { assert it == 'Groovy'})
work('Groovy') {
    assert it == 'Groovy'
}

// 새줄에서 { } 를 둬도 closure로 인식한다.
work('Groovy')
{
    assert it == 'Groovy'
}

// 괄호 없을 때는 comma 주의
work 'Groovy', {
    assert it == 'Groovy'
}