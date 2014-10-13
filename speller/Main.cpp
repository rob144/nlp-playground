#include "Trie.hpp"
#include "TrieNode.hpp"
#include <iostream>
using namespace std;

int main () {
    
    TrieNode trie = TrieNode();
    TrieNode * ptr_trie = &trie;
    
    //TODO: read words from a dictionary file
    Trie::insertWord(ptr_trie, "and");
    Trie::insertWord(ptr_trie, "apple");
    Trie::insertWord(ptr_trie, "abundant");
    Trie::insertWord(ptr_trie, "fishing");

    Trie::printTrie(ptr_trie);
    
    return 0;
}
