assert 'I 10v3 9r00vy' == 'I love Groovy'.tr('loeG', '1039')
assert 'mrHAKI' == 'mrhaki'.tr('a-k', 'A-K')

assert 'Gr8888' == 'Groovy'.tr('ovy', '8') // o,v,y 가 모두 8로 변환.
