import { Component, EventEmitter, Output } from '@angular/core';
import { ApiService } from '../../api.service';
import { Router } from '@angular/router'; // Importação do Router

@Component({
  selector: 'app-botao-upload',
  templateUrl: './botao-upload.component.html',
  styleUrls: ['./botao-upload.component.css'],
})
export class BotaoUploadComponent {
  @Output() reload = new EventEmitter<boolean>();
  public loading = false;
  constructor(public apiService: ApiService, private router: Router) {}

  public sendFile(event: any): void {
    const file = event.target.files[0];
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    this.loading = true;
    this.apiService.sendData(formData).subscribe(
      (response: { message: any }) => {
        window.alert(response.message);
        this.reload.emit(true);
        this.loading = false;
      },
      (error: any) => {
        console.error('Erro ao enviar o arquivo', error);
        this.loading = false;
      }
    );
  }
}
