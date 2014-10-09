#include "Trie.hpp"
#include "TrieNode.hpp"
#include <iostream>
using namespace std;

int main () {
    TrieNode t1 ('a');
    cout << "TrieNode: " << t1.letter << '\n';
    cout << "PrintTrie: " << Trie::printTrie() << '\n';
    return 0;
}