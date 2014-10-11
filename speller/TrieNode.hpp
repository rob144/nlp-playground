#pragma once
class TrieNode {

public:
    char letter;
    TrieNode *links[42];
    bool fullWord;
    
    TrieNode () { }
    TrieNode (char l) {
        letter = l;
        fullWord = false;
    } 
        
};

