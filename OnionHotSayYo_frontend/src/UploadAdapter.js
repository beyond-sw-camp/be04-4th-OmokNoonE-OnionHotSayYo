import axios from 'axios';

export default class UploadAdapter {
    constructor(loader, url) {
        this.url = 'http://localhost:8081/post.json';
        this.loader = loader;
        this.loader.file.then((pic) => (this.file = pic));

        this.upload();
    }

    // Starts the upload process.
    upload() {
        return this.loader.file.then((uploadedFile) => {
            return new Promise((resolve, reject) => {
                const formData = new FormData();
                formData.append('TITLE', title); 
                formData.append('CONTENT', content); 
                formData.append('IMAGE', image); 

                axios.post(this.url, formData)
                    .then((res) => {
                        const returnUrl = res.data.result.image_url; // Adjust the data structure according to your server response
                        resolve({
                            default: returnUrl, // No need to append context path if it's already included in the server response
                        });
                    })
                    .catch((error) => {
                        console.error(error);
                        reject(error.response ? error.response.data.message : 'Upload failed');
                    });
            });
        });
    }
}