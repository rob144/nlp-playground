#include "Trie.hpp"
#include "TrieNode.hpp"
#include <iostream>
using namespace std;

int main () {
    TrieNode t1 ('a');
    Trie::insertWord(&t1, "apple");
    cout << "TrieNode: " << t1.letter << '\n';
    cout << "PrintTrie: " << Trie::printTrie(t1) << '\n';
    return 0;
}
