document.getElementById('addBookForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const title = document.getElementById('bookTitle').value;
    const author = document.getElementById('bookAuthor').value;
    const isbn = document.getElementById('bookISBN').value;

    const newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td>${title}</td>
        <td>${author}</td>
        <td>${isbn}</td>
        <td><button class="btn btn-danger" onclick="deleteBook(this)">Delete</button></td>
    `;
    document.getElementById('book-list').appendChild(newRow);
    $('#addBookModal').modal('hide');
    this.reset();
});

function deleteBook(button) {
    const row = button.parentElement.parentElement;
    row.parentElement.removeChild(row);
}

function searchBooks() {
    const query = document.getElementById('searchInput').value.toLowerCase();
    const results = document.getElementById('search-results');
    results.innerHTML = ''; // Clear previous results

    // Sample data for demonstration
    const books = [
        { title: 'The Great Gatsby', author: 'F. Scott Fitzgerald' },
        { title: '1984', author: 'George Orwell' },
        { title: 'To Kill a Mockingbird', author: 'Harper Lee' }
    ];

    const filteredBooks = books.filter(book => 
        book.title.toLowerCase().includes(query) || 
        book.author.toLowerCase().includes(query)
    );

    filteredBooks.forEach(book => {
        const newRow = document.createElement('tr');
        newRow.innerHTML = `
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td><button class="btn btn-success">Borrow</button></td>
        `;
        results.appendChild(newRow);
    });
}