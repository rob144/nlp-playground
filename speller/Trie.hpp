#pragma once
#include "TrieNode.hpp"
#include <iostream>
#include <string.h>

using namespace std;

class Trie
{
private:
    //a-z (26) + A-Z (26) + 0-9 (10) = 62
    static const int NUM_OF_LINKS = 62;
    static const int MAX_DEPTH = 200;
public:
    static void insertWord(TrieNode *ptr_root, const char ptr_chars[]){
        int offset = 97;
        TrieNode *ptr_node = ptr_root;
        
        while(*ptr_chars){
            int index = *ptr_chars - offset;
            //Add node if there is a space at the relevant position 
            if (ptr_node->links[index] == NULL){
                ptr_node->links[index] = new TrieNode (*ptr_chars);
            }
            //Get child node at the relevant position on the next level
            ptr_node = ptr_node->links[index];
            ptr_chars++;
        }
        ptr_node->fullWord = true;  
    }
   
    static void printTrie(TrieNode *ptr_root){
        char branch[MAX_DEPTH + 1] = {};
        printTrieNode(ptr_root, 0, branch);
    }

    static void printTrieNode(TrieNode *ptr_node, int level, char branch[]){
        if (ptr_node == NULL)
            return;
        
        branch[level] = ptr_node->letter;
        
        //Recurse through all the child nodes looking for more letters
        for (int i = 0; i < NUM_OF_LINKS; i++){ 
            printTrieNode(ptr_node->links[i], level+1, branch);    
        }       
        if (ptr_node->fullWord) 
            printWord(branch, level);
    }

    static void printWord(char branch[], int length){
        for(int i=1; i <= length && i < MAX_DEPTH; i++){
            if(branch[i] == '\0') break;
            cout << branch[i];
        }
        cout << "\n";
    }

};
