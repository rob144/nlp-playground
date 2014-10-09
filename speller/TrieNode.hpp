#pragma once
class TrieNode {

public:
    char letter;
    TrieNode *links;
    bool fullWord;
    
    TrieNode () { }
    TrieNode (char l) {
        letter = l;
        links = new TrieNode[42];
        fullWord = false;
    } 
        
};

