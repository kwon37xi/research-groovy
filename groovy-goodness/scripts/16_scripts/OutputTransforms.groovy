// ~/.groovy/OutputTransforms.groovy 파일을 생성해 두면 GroovyConsole의 출력을 조정할 수 있다.
// View -> Visualize Script results 가 켜져 있어야한다.

import javax.swing.JLabel
import javax.swing.ImageIcon

transforms << { result ->
    if (result instanceof String) {
        if (result ==~ /<html>.*<\/html>/) {
            return new JLabel(result)
        } else if (result == 'mrhaki') {
            return new ImageIcon('/home/kwon37xi/IdeaProjects/programming-language-background-images/images/groovy.png')
        } else {
            return "Groovy console says: $result"
        }
    }
}
