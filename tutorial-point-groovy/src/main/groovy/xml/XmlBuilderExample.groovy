package xml

import groovy.xml.MarkupBuilder

/**
 *
 */
class XmlBuilderExample {
    static void main(String[] args) {
        def builder = new MarkupBuilder(new PrintWriter(System.out))
        builder.collection(shelf: 'New Arrivals') {
            movie(title: 'Enemy Behind') {
                type('War, Thriller')
                format('DVD')
                year('2003')
                rating('PG')
                stars(10)
                description('Talk about a US-Japan War')
            }
        }

        def mp = [1: ['Enemy Behind', 'War, Thriller', 'DVD', '2003',
                      'PG', '10', 'Talk about a US-Japan war'],
                  2: ['Transformers', 'Anime, Science Fiction', 'DVD', '1989',
                      'R', '8', 'A scientific fiction'],
                  3: ['Trigun', 'Anime, Action', 'DVD', '1986',
                      'PG', '10', 'Vash the Stam pede'],
                  4: ['Ishtar', 'Comedy', 'VHS', '1987', 'PG',
                      '2', 'Viewable boredom ']]

        def builder2 = new MarkupBuilder(new PrintWriter(System.out))
        builder2.collection(shelf: 'New Arrivals') {
            mp.each { sd ->
                builder2.movie(title: sd.value[0]) {
                    type(sd.value[1])
                    format(sd.value[2])
                    year(sd.value[3])
                    rating(sd.value[4])
                    stars(sd.value[5])
                    description(sd.value[6])
                }
            }
        }
    }
}
