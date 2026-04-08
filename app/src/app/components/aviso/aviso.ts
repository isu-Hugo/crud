import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AvisosService } from './../../services/avisos-service';
import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-aviso',
  imports: [ReactiveFormsModule],
  templateUrl: './aviso.html',
  styleUrl: './aviso.css',
})
export class Aviso {

  constructor(private avisosService: AvisosService){}

  //avisos: any[] = [];
  avisos = signal<any[]>([]);

  verAvisos(){
    this.avisosService.getAvisos().subscribe({
      next: (response) =>{
        console.log(response)
        //this.avisos = response;
        this.avisos.set(response);
      },
      error: (error) =>{
        console.error(error);
      }
    })
  }

  salvarAviso(){
    const info = {
      title: this.avisoForms.value.title,
      message: this.avisoForms.value.message
    }

    this.avisosService.postAvisos(info).subscribe({
      next: (response) =>{
        console.log(response)
      },
      error: (error) =>{
        console.error(error);
      }
    })

  }

  avisoForms = new FormGroup({
    title: new FormControl(),
    message: new FormControl()
  })



}
