@groovy.transform.Sortable
@groovy.transform.ToString
class User {
    String username, email
}

def mrhaki1 = new User(username: 'mrhaki', email: 'mrhaki@localhost')
def mrhaki2 = new User(username: 'mrhaki', email: 'user@localhost')
def hubert1 = new User(username: 'hubert', email: 'user@localhost')
def hubert2 = new User(username: 'hubert', email: 'hubert@localhost')

// Immutable list
def users = [mrhaki1, mrhaki2, hubert1, hubert2].asImmutable()

def sortedUsers = users.toSorted()

// @Sortable adds a compareTo method to User class to sort first by username and then email.

assert sortedUsers == [hubert2, hubert1, mrhaki1, mrhaki2]

assert users == [mrhaki1, mrhaki2, hubert1, hubert2] // original unchanged

// Use toSorted with closure
def sortedByEmail = users.toSorted { a, b -> a.email <=> b.email }
assert sortedByEmail == [hubert2, mrhaki1, mrhaki2, hubert1]

// or use toSorted with Comparator.
// @Sortable added static comparatorBy[Property] method
def sortedByEmailComparator = users.toSorted(User.comparatorByEmail())
assert sortedByEmailComparator == [hubert2, mrhaki1, mrhaki2, hubert1]

// toUnique with Comparator
def uniqueUsers = users.toUnique(User.comparatorByUsername())
assert uniqueUsers == [mrhaki1, hubert1]
assert users == [mrhaki1, mrhaki2, hubert1, hubert2]

// toUnique with closure
def uniqueByEmail = users.toUnique { a, b -> a.email <=> b.email }
assert uniqueByEmail == [mrhaki1, mrhaki2, hubert2]