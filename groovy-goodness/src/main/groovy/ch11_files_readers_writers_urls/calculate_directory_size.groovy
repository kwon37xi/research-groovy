// File.directorySize() - 모든 subdirectory 재귀적으로 계산.
// File 객체가 디렉토리가 아니면 IllegalArgumentException 발생

def sampleDir = new File('/tmp')
def sampleDirSize = sampleDir.directorySize()
println sampleDirSize

"""
groovy -e "println new File('.').directorySiz()
"""