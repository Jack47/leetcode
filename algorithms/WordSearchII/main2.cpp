#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<string>
#include<vector>

using namespace std;
class TrieNode {
public:
    const static int kLetterMaxSize = 26;
    TrieNode() {
        _count = 0;
        memset(_children, 0, sizeof(TrieNode*)*kLetterMaxSize);
    }
    int _count; // word count, word ends with this letter
    TrieNode* _children[kLetterMaxSize];
};

class Trie {
public:
    Trie() {};
    ~Trie();
    void insert(const string& word);
    bool search(const string& word) const;
    bool startsWith(const string& prefix) const;
private:
    void freeNode(TrieNode* node);
private:    
    TrieNode _root;
};
Trie::~Trie() {
    TrieNode* child_node = &_root;

    for (int i = 0; i <= TrieNode::kLetterMaxSize-1; i++) {
        if (child_node->_children[i] != NULL) {
            freeNode(child_node->_children[i]);
        }
    }
}
void Trie::freeNode(TrieNode* node) {

    for (int i =0; i <= TrieNode::kLetterMaxSize-1; i++) {
        if (node->_children[i] != NULL) {
            //freeNode(node->_children[i]);
        }
    }
    delete node;
}
void Trie::insert(const string& word) {
    if (word.empty()) {
        return;
    }
    TrieNode* child_node = NULL;
    TrieNode* parent_node = &_root;
    char* data = const_cast<char*>(word.data());
    while(data[0] != '\0') {
        int index = data[0]-'a';
        if (parent_node->_children[index] == NULL) {
            parent_node->_children[index] = new TrieNode();
            parent_node->_children[index]->_count = 0;
        }
        child_node = parent_node->_children[index];
        ++data;
        parent_node = child_node;
    }
    ++(parent_node->_count);
};
bool Trie::startsWith(const string& prefix) const {
    if (prefix.empty()) {
        return false;
    }
    const TrieNode* child_node = &_root;
    char* data = const_cast<char*>(prefix.data());
    int index = data[0]-'a';    
    child_node = _root._children[index];
    while (child_node != NULL) { // has index
        ++data;        
        if (data[0] == '\0') {
            return true;
        }
        index = data[0]-'a';        
        child_node = child_node->_children[index];
    }
    return false;
}
bool Trie::search(const string& word) const {
    if (word.empty()) {
        return false;
    }
    const TrieNode* child_node = &_root;
    char* data = const_cast<char*>(word.data());
    int index = data[0]-'a';    
    child_node = _root._children[index];
    while (child_node != NULL) { // has index
        ++data;        
        if (data[0] == '\0') {
            if (child_node->_count > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        index = data[0]-'a';        
        child_node = child_node->_children[index];
    }
    return false;
}
class Solution {
public:
    const static int kMaxWordLen = 5000;    
    vector<string> findWords(vector<vector<char> >& board, vector<string>& words) {
        vector<string> wordsExist;
        
        Trie trie;
        for (int i = 0; i < static_cast<int>(words.size()); i++) {
            //printf("insert to trie:%s\n", words[i].data());
            trie.insert(words[i]);
        }
        getAllWords(board, trie, &wordsExist);
        return wordsExist;
    }
private:
    void getAllWords(vector<vector<char> >& board, const Trie& trie, vector<string>* wordsExist) {
        string word;
        word.reserve(kMaxWordLen);
        for (int i = 0; i <= static_cast<int>(board.size())-1; i++) {
            for (int j = 0; j <= static_cast<int>(board[0].size())-1; j++) {
                word.clear();
                getWords(board, i, j, trie, &word, wordsExist);
            }
        }
    }
    void getWords(vector<vector<char> >& board, int i, int j, const Trie& trie, string* word, vector<string>* wordsExist) {
        char c = board[i][j];
        word->push_back(c);
        bool exist = trie.startsWith(*word);
        if (!exist) { // stop backtracking immediately.
            word->resize(word->size()-1);
            return;
        }
        board[i][j] = '#';
        if (i-1 >= 0 && board[i-1][j] != '#') {
            getWords(board, i-1, j, trie, word, wordsExist);
        }

        if (i+1 < static_cast<int>(board.size()) && board[i+1][j] != '#') {
            getWords(board, i+1, j, trie, word, wordsExist);
        }
        if (j-1 >= 0 && board[i][j-1] != '#') {
            getWords(board, i, j-1, trie, word, wordsExist);
        }
        if (j+1 < static_cast<int>(board[0].size()) && board[i][j+1] != '#') {
            getWords(board, i, j+1, trie, word, wordsExist);
        }
        exist = trie.search(*word);
        // printf("current word:%s\n", word->data());
        if (exist) {
            int i = 0;
            for (i = 0; i < static_cast<int>(wordsExist->size()); i++) { // keep  elements distinct. Other wise will have many duplicate string in board
                if ((*wordsExist)[i].compare(*word) == 0) {
                    break;
                }
            }
            if (i == static_cast<int>(wordsExist->size())) {
                wordsExist->push_back(*word);
            }
        }        
        word->resize(word->size()-1);
        board[i][j] = c;
    }
};
vector<vector<char> > buildBoard(char b[][7], int end_row, int end_col) {
    vector<vector<char> > board;
    for (int i = 0; i < end_row; i++) {
        vector<char> column(b[i], b[i]+end_col);
        board.push_back(column);
    }
    return board;
}
int main() {
    vector<vector<char> > board;
    char b[5][7] = {
        "bbaaba",
        "bbabaa",
        "bbbbbb",
        "aaabaa",
        "abaabb"
    };


    board = buildBoard(b, 5, 6);
    Solution solution;
    vector<string> words;
    words.push_back("oath");
    words.push_back("pea");
    words.push_back("eat");
    words.push_back("rain");
    words.push_back("abbbababaa");
    vector<string> existWords = solution.findWords(board, words);
    printf("%zu\n", existWords.size());
    for (int i = 0; i < static_cast<int>(existWords.size()); i++) {
        printf("%s\n", existWords[i].data());
    }
    return 0;
}
