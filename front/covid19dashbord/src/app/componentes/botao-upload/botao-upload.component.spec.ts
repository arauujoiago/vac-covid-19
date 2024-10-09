import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BotaoUploadComponent } from './botao-upload.component';

describe('BotaoUploadComponent', () => {
  let component: BotaoUploadComponent;
  let fixture: ComponentFixture<BotaoUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BotaoUploadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BotaoUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
