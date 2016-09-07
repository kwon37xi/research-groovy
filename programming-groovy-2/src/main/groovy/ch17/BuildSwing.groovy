import groovy.swing.SwingBuilder

import javax.swing.WindowConstants

builder = new SwingBuilder()

frame = builder.frame(
        title: 'Swing',
        size: [50, 100],
        layout: new java.awt.FlowLayout(),
        defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
) {
    lbl = label(text: 'test')
    btn = button(text: 'Click me', actionPerformed: {
        btn.text = 'Clicked'
        lbl.text = 'Groovy!'
    })
}

frame.visible = true
