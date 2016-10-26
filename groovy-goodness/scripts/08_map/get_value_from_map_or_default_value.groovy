def m = [name: 'mrhaki', language: 'Groovy']

assert 'mrhaki' == m.getAt('name')
assert 'mrhaki' == m['name']
assert 'Groovy' == m.language
assert 'mrhaki' == m."name"
assert 'mrhaki' == m.get('name')
assert 'Groovy' == m.get('language', 'Java') // defualt value 'Java'
assert null == m.get('expression')
assert 'rocks' == m.get('expression', 'rocks') // default value 'rocks'
assert 'rocks' == m.get('expression') // 한번 기본값으로 호출하면 해당 키에 값이 들어감.

assert [name: 'mrhaki', language: 'Groovy', expression: 'rocks'] == m