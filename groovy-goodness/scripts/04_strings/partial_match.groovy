def identification = /[A-Z]{2}\-\d{3,5}/

def matcher = 'AB-1234' =~ identification
assert matcher.matchesPartially()
assert matcher.matches()

matcher = 'XY-90' =~ identification
assert matcher.matchesPartially()
assert !matcher.matches() // 숫자가 3자리부터 5자리까지가 안돼서 파셜 매칭만 됨.

matcher = 'HA' =~ identification
assert matcher.matchesPartially()
assert !matcher.matches()

matcher = 'A-431' =~ identification
assert !matcher.matchesPartially() // 뒷부분 일치는 partialMatching 아님.

assert 'YK-901201' =~ identification
assert !matcher.matchesPartially() // 뒷부분 불일치
