# Exercise – Multiple HTTP Downloads & Merging Results

## Objective

The objective of this exercise is to write a small software application that performs the following tasks:

1. Takes a list of URLs (e.g., raw GitHub READMEs).
2. Downloads each URL, checking for errors.
3. If any error occurs with any URL, the program should exit and print the error.
4. If all downloads succeed, the contents of all downloads are appended together and printed in reverse order from the list of URLs.

### Example URLs (can be hardcoded):

- [README.md from GoogleContainerTools/distroless](https://raw.githubusercontent.com/GoogleContainerTools/distroless/main/java/README.md)
- [README.md from golang/go](https://raw.githubusercontent.com/golang/go/master/README.md)

## Additional Improvements

To extend the exercise further, consider implementing the following improvements:

- Modify the program to create an HTTP server that returns the downloaded texts as responses when called via a GET request.
- Implement parallel downloading of responses and cancel all downloads upon encountering any error.


### Installation

1. Clone the repository:

   ```bash
   git clone git@github.com:Khaled12208/MultipleHTTPdownloads.git
   cd MultipleHTTPdownloads
