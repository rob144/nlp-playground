#pragma once
class TrieNode {

public:
    static const int MAX_DEPTH = 200;
    char letter;
    TrieNode *links[MAX_DEPTH];
    bool fullWord;
    
    TrieNode () { }
    TrieNode (char l) {
        letter = l;
        fullWord = false;
    } 
        
};

