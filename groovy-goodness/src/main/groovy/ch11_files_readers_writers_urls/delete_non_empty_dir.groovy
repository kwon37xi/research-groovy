// File.deleteDir() : non empty dir 삭제
def mainDir = new File('/tmp/groovy/test')
def subDir = new File(mainDir, 'app')
def file = new File(subDir, 'test.txt')
subDir.mkdirs()
file << 'sample'

assert mainDir.exists() && subDir.exists() && file.exists()

def result = mainDir.deleteDir()
assert result
assert !mainDir.exists() && !subDir.exists() && !file.exists()

